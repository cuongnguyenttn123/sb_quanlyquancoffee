package com.thecoffeshop.controller.admin;

import com.thecoffeshop.DTO.RegisterDTO;
import com.thecoffeshop.DTO.ScheduleDTO;
import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.entity.Register;
import com.thecoffeshop.entity.Schedule;
import com.thecoffeshop.service.EmployeeService;
import com.thecoffeshop.service.RegisterService;
import com.thecoffeshop.service.ScheduleService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class PersonalController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    RegisterService registerService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employee/work-schedule")
    public String index(ModelMap modelMap) {

        List<ScheduleDTO> scheduleDTOs = new ArrayList<ScheduleDTO>();
        List<Schedule> schedules = scheduleService.findAll();
        for (Schedule schedule : schedules) {
            ScheduleDTO dto = new ScheduleDTO();
            String StartTime = schedule.getStarttime().toString().substring(0, 5);
            String EndTime = schedule.getEndtime().toString().substring(0, 5);
            dto.setScheduleid(schedule.getScheduleid());
            dto.setStarttime(StartTime);
            dto.setEndtime(EndTime);
            scheduleDTOs.add(dto);
        }

        modelMap.addAttribute("scheduleDTOs", scheduleDTOs);

        Calendar c = Calendar.getInstance();
        int now = c.get(Calendar.DAY_OF_WEEK);
        c.add(c.DAY_OF_MONTH, 8 - now);
        Date from = c.getTime();
        c.add(c.DAY_OF_MONTH, 7);
        Date to = c.getTime();
        java.sql.Date from1 = new java.sql.Date(from.getTime());
        java.sql.Date to1 = new java.sql.Date(to.getTime());
        List<Register> registers = registerService.getListRegisterOnWeek(from1, to1);

        List<RegisterDTO> dtos = new ArrayList<RegisterDTO>();
        c.setTime(from);
        for (int i = 1; i <= 7; i++) {
            for (Schedule schedule : schedules) {
                String scheduleid = schedule.getScheduleid();
                RegisterDTO dto = new RegisterDTO();
                dto.setDay(i);
                dto.setScheduleid(scheduleid);
                java.sql.Date to2 = new java.sql.Date(c.getTime().getTime());
                List<Register> registers2 = registerService.getScheduleEmployee(to2, scheduleid, "1");
                dto.setRegisters(registers2);

                dtos.add(dto);
            }
            c.roll(c.DAY_OF_MONTH, 1);
        }

        modelMap.addAttribute("dtos", dtos);

        return "/admin/management-employee/personnal";
    }

    @GetMapping(value = "/employee/info")
    public String getInfo(ModelMap modelMap, Principal principal) {
        User loginUser = (User) ((Authentication) principal).getPrincipal();
        Employee employee = employeeService.getEmployeeByUser(loginUser.getUsername());
        modelMap.addAttribute("employee", employee);

        return "/admin/management-employee/info";
    }
    @GetMapping(value = "/employee/password")
    public String getEditPass() {
        return "/admin/management-employee/password";
    }

    @PostMapping(value = "/employee/editpassword", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String editPassword(Principal principal,@RequestParam("oldpassword")String oldpassword ,@RequestParam("newpassword")String newpassword){
        try {
            User loginUser = (User) ((Authentication) principal).getPrincipal();
            Employee employee = employeeService.getEmployeeByUser(loginUser.getUsername());
            if (BCrypt.checkpw(oldpassword, employee.getPassword())){
                String hash = BCrypt.hashpw(newpassword, BCrypt.gensalt(12));
                employee.setPassword(hash);
                employeeService.editEmployee(employee);
                return "Đổi mật khẩu thành công";
            }else {
                return "Mật khẩu không đúng vui lòng nhật lại";
            }
        }catch (Exception e){
            return "Thất bại";
        }

    }


}
