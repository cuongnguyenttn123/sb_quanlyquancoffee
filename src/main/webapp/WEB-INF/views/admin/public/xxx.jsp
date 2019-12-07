
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Stellar Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../resources/node_modules/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="../resources/node_modules/simple-line-icons/css/simple-line-icons.css">
  <link rel="stylesheet" href="../resources/node_modules/flag-icon-css/css/flag-icon.min.css">
  <link rel="stylesheet" href="../resources/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="../resources/node_modules/chartist/dist/chartist.min.css" />
  <link rel="stylesheet" href="../resources/node_modules/jvectormap/jquery-jvectormap.css" />
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../resources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../resources/../images/favicon.png" />
</head>

<body class="horizontal-menu">
  <div class="container-scroller">
    <!-- partial:../resources/partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper">
        <a class="navbar-brand brand-logo" href="../resources/index.html"><img src="../resources/images/logo.svg" alt="logo"></a>
        <a class="navbar-brand brand-logo-mini" href="../resources/index.html"><img src="../resources/images/logo_mini.svg" alt="logo"></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center">
        <button class="navbar-toggler navbar-toggler d-none d-lg-block align-self-center mr-2" type="button" data-toggle="minimize">
        <span class="icon-list icons"></span>
      </button>
        <p class="page-name d-none d-lg-block">Hi, Dave Mattew</p>
        <ul class="navbar-nav ml-lg-auto">
          <li class="nav-item">
            <form class="mt-2 mt-md-0 d-none d-lg-block search-input">
              <div class="input-group">
                <span class="input-group-addon d-flex align-items-center"><i class="icon-magnifier icons"></i></span>
                <input type="text" class="form-control" placeholder="Search...">
              </div>
            </form>
          </li>
          <li class="nav-item dropdown mail-dropdown">
            <a class="nav-link count-indicator" id="MailDropdown" href="#" data-toggle="dropdown">
                <i class="icon-envelope-letter icons"></i>
                <span class="count bg-danger"></span>
            </a>
            <div class="dropdown-menu navbar-dropdown mail-notification dropdownAnimation" aria-labelledby="MailDropdown">
              <a class="dropdown-item" href="#">
                <div class="sender-img">
                  <img src="../resources/images/faces/face6.jpg" alt="">
                  <span class="badge badge-success">&nbsp;</span>
                </div>
                <div class="sender">
                  <p class="Sende-name">John Doe</p>
                  <p class="Sender-message">Hey, We have a meeting planned at the end of the day.</p>
                </div>
              </a>
              <a class="dropdown-item" href="#">
                <div class="sender-img">
                  <img src="../resources/images/faces/face2.jpg" alt="">
                  <span class="badge badge-success">&nbsp;</span>
                </div>
                <div class="sender">
                  <p class="Sende-name">Leanne Jones</p>
                  <p class="Sender-message">Can we schedule a call this afternoon?</p>
                </div>
              </a>
              <a class="dropdown-item" href="#">
                <div class="sender-img">
                  <img src="../resources/images/faces/face3.jpg" alt="">
                  <span class="badge badge-primary">&nbsp;</span>
                </div>
                <div class="sender">
                  <p class="Sende-name">Stella</p>
                  <p class="Sender-message">Great presentation the other day. Keep up the good work!</p>
                </div>
              </a>
              <a class="dropdown-item" href="#">
                <div class="sender-img">
                  <img src="../resources/images/faces/face4.jpg" alt="">
                  <span class="badge badge-warning">&nbsp;</span>
                </div>
                <div class="sender">
                  <p class="Sende-name">James Brown</p>
                  <p class="Sender-message">Need the updates of the project at the end of the week.</p>
                </div>
              </a>
              <a href="#" class="dropdown-item view-all">View all</a>
            </div>
          </li>
          <li class="nav-item dropdown notification-dropdown">
            <a class="nav-link count-indicator" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="icon-speech icons"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu navbar-dropdown preview-list notification-drop-down dropdownAnimation" aria-labelledby="notificationDropdown">
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon">
                    <i class="icon-info mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject font-weight-medium">Application Error</p>
                  <p class="font-weight-light small-text">
                    Just now
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon">
                    <i class="icon-speech mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject">Settings</p>
                  <p class="font-weight-light small-text">
                    Private message
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon">
                    <i class="icon-envelope mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <p class="preview-subject">New user registration</p>
                  <p class="font-weight-light small-text">
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item lang-dropdown d-none d-sm-block">
            <a class="nav-link" href="#">
              <p class="mb-0">English <i class="flag-icon flag-icon-gb"></i></p>
            </a>
          </li>
          <li class="nav-item d-none d-sm-block profile-img">
            <a class="nav-link profile-image" href="#">
              <img src="../resources/images/faces/face4.jpg" alt="profile-img">
              <span class="online-status online bg-success"></span>
            </a>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center ml-auto" type="button" data-toggle="offcanvas">
          <span class="icon-menu icons"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <div class="row row-offcanvas row-offcanvas-right">
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item">
              <a class="nav-link" data-toggle="collapse" href="#menu1" aria-expanded="false" aria-controls="icons">
                <i class="icon-screen-desktop menu-icon"></i>
                <span class="menu-title">Menu 1</span>
              </a>
              <div class="collapse" id="menu1">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                </ul>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" data-toggle="collapse" href="#menu2" aria-expanded="false" aria-controls="icons">
                <i class="icon-speedometer menu-icon"></i>
                <span class="menu-title">Menu 2</span>
              </a>
              <div class="collapse" id="menu2">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                </ul>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" data-toggle="collapse" href="#menu3" aria-expanded="false" aria-controls="icons">
                <i class="icon-home menu-icon"></i>
                <span class="menu-title">Menu 3</span>
              </a>
              <div class="collapse" id="menu3">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                </ul>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" data-toggle="collapse" href="#menu4" aria-expanded="false" aria-controls="icons">
                <i class="icon-chart menu-icon"></i>
                <span class="menu-title">Menu 4</span>
              </a>
              <div class="collapse" id="menu4">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                  <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                </ul>
              </div>
            </li>
            <li class="nav-item mega-menu">
                <a class="nav-link" data-toggle="collapse" href="#mega-menu-1" aria-expanded="false" aria-controls="icons">
                  <i class="icon-flag menu-icon"></i>
                  <span class="menu-title">Mega Menu</span>
                </a>
                <div class="collapse" id="mega-menu-1">
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 1</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 2</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 3</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 4</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 5</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                  <div class="mega-menu-section">
                    <ul class="nav flex-column sub-menu">
                      <li class="mega-menu-title">
                        <span class="nav-link">Section 6</span>
                      </li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link One</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Two</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Three</a></li>
                      <li class="nav-item"> <a class="nav-link" href="#">Sample Link Four</a></li>
                    </ul>
                  </div>
                </div>
              </li>
          </ul>
        </nav>
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card overflow-hidden dashboard-curved-chart">
                <div class="card-body mx-3">
                  <h2 class="card-title border-bottom-none">Recent Movement</h2>
                  <div class="align-items-center mb-5 justify-content-between d-lg-flex d-xl-flex d-md-block d-block">
                    <div id="chartLegend"></div>
                    <div class="nav-wrapper d-inline-block mt-4 mt-lg-0">
                      <ul class="nav nav-pills">
                        <li class="nav-item">
                          <a class="nav-link" href="#">Week</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link active" href="#">Month</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Year</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Today</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div id="curved-line-chart" class="float-chart float-chart-mini"></div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card performance-cards">
                <div class="card-body">
                  <div class="row">
                    <div class="col d-flex flex-row justify-content-center align-items-center">
                      <div class="wrapper icon-circle bg-success">
                        <i class="icon-rocket icons"></i>
                      </div>
                      <div class="wrapper text-wrapper">
                        <p class="text-dark">8954</p>
                        <p>Lifetime total sales</p>
                      </div>
                    </div>
                    <div class="col d-flex flex-row justify-content-center align-items-center">
                      <div class="wrapper icon-circle bg-danger">
                        <i class="icon-briefcase icons"></i>
                      </div>
                      <div class="wrapper text-wrapper">
                        <p class="text-dark">7841</p>
                        <p>Income amounts</p>
                      </div>
                    </div>
                    <div class="col d-flex flex-row justify-content-center align-items-center">
                      <div class="wrapper icon-circle bg-warning">
                        <i class="icon-umbrella icons"></i>
                      </div>
                      <div class="wrapper text-wrapper">
                        <p class="text-dark">6521</p>
                        <p>Total users</p>
                      </div>
                    </div>
                    <div class="col d-flex flex-row justify-content-center align-items-center">
                      <div class="wrapper icon-circle bg-primary">
                        <i class="icon-check icons"></i>
                      </div>
                      <div class="wrapper text-wrapper">
                        <p class="text-dark">325</p>
                        <p>Total visits</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-12 grid-margin stretch-card">
              <div class="card current-progress-card">
                <div class="card-body">
                <h2 class="card-title">Current Progress</h2>
                <div class="row">
                  <div class="col">Bootstrap Admin</div>
                  <div class="col">
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-primary" role="progressbar" style="width: 64%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col">Custom Work</div>
                  <div class="col">
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-success" role="progressbar" style="width: 24%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col">Clients Module</div>
                  <div class="col">
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-info" role="progressbar" style="width: 52%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col">Email Templates</div>
                  <div class="col">
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-danger" role="progressbar" style="width: 69%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col">Plans Module</div>
                  <div class="col">
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-warning" role="progressbar" style="width: 78%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
              </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 grid-margin stretch-card">
              <div class="card calender-card">
                <div class="card-body">
                <h2 class="card-title">Calender</h2>
                <div class="datepicker"></div>
              </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-12 col-sm-12 grid-margin stretch-card">
              <div class="card quick-stat">
                <div class="card-body">
                <h2 class="card-title">Quick Status</h2>
                <div class="row mt-3">
                  <div class="col">
                    <div id="YearlyProgress" class="progressbar-js-circle item-relative"></div>
                    <p class="graph-name text-center mt-2">Yearly Income</p>
                  </div>
                  <div class="col">
                    <div id="MonthlyProgress" class="progressbar-js-circle item-relative"></div>
                    <p class="graph-name text-center mt-2">Monthly Income</p>
                  </div>
                </div>
                <div class="pending-amount">
                  <div class="data d-flex justify-content-between">
                    <p class="txt">Pending Amount</p>
                    <p class="pendin-percentage">65%</p>
                  </div>
                  <div class="progress">
                    <div class="progress-bar bg-primary" role="progressbar" style="width: 65%" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                  </div>
                </div>
              </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row">
            <div class="col-12 col-lg-4 col-md-4 grid-margin stretch-card">
              <div class="card px-3">
                <div class="card-body">
                  <h2 class="card-title">Business Grid</h2>
                  <div id="c3-pie-chart" class="mb-4"></div>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-8 col-md-8 grid-margin stretch-card">
              <div class="card px-3">
                <div class="card-body">
                  <h2 class="card-title">Growth</h2>
                  <div class="ct-chart" id="ct-chart-vartical-stacked-bar"></div>
                </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row section social-section">
            <div class="col-lg-4 grid-margin stretch-card">
              <div class="social-card w-100 bg-facebook">
                <div class="social-icon">
                  <i class="icon-social-facebook icons"></i>
                </div>
                <div class="content">
                  <p>+ 1500</p>
                  <p>Facebook Likes</p>
                </div>
              </div>
            </div>
            <div class="col-lg-4 grid-margin stretch-card">
              <div class="social-card w-100 bg-twitter">
                <div class="social-icon">
                  <i class="icon-social-twitter icons"></i>
                </div>
                <div class="content">
                  <p>+574</p>
                  <p>Twitter Followers</p>
                </div>
              </div>
            </div>
            <div class="col-lg-4 grid-margin stretch-card">
              <div class="social-card w-100 bg-dribbble">
                <div class="social-icon">
                  <i class="icon-social-dribbble icons"></i>
                </div>
                <div class="content">
                  <p>+450</p>
                  <p>Dribble Shots</p>
                </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row">
            <div class="col-12 col-lg-5 col-md-5 grid-margin stretch-card">
              <div class="card px-3 activity-card">
                <div class="card-body">
                  <h2 class="card-title">Latest Activity</h2>
                  <div class="col">
                    <div class="pic pr-3"><img src="../resources/images/faces/face1.jpg" alt=""></div>
                    <div class="content">
                      <p class="activity">Create New Page</p>
                      <p class="a-text">Vestibulum lectus nulla, maximus</p>
                    </div>
                    <div class="time">
                      <p>Just Now</p>
                    </div>
                  </div>
                  <div class="col">
                    <div class="pic pr-3"><img src="../resources/images/faces/face2.jpg" alt=""></div>
                    <div class="content">
                      <p class="activity">Back Up Theme</p>
                      <p class="a-text">Vestibulum lectus nulla, maximus </p>
                    </div>
                    <div class="time">
                      <p>Sept 13, 2018</p>
                      <p>3 mins</p>
                    </div>
                  </div>
                  <div class="col">
                    <div class="pic pr-3"><img src="../resources/images/faces/face3.jpg" alt=""></div>
                    <div class="content">
                      <p class="activity">Changes In The Structure</p>
                      <p class="a-text">Vestibulum lectus nulla, maximus </p>
                    </div>
                    <div class="time">
                      <p>Sept 07, 2018</p>
                      <p>4 mins</p>
                    </div>
                  </div>
                  <div class="col">
                    <div class="pic pr-3"><img src="../resources/images/faces/face4.jpg" alt=""></div>
                    <div class="content">
                      <p class="activity">Fix the Sidebar</p>
                      <p class="a-text">Vestibulum lectus nulla, maximus</p>
                    </div>
                    <div class="time">
                      <p>Sept 16, 2018</p>
                      <p>15 mins</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-7 col-md-7 grid-margin stretch-card">
              <div class="card activity-card">
                <div class="card-body">
                  <h2 class="card-title">World Map</h2>
                  <div id="dashboard-vmap" class="vector-map"></div>
                </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card px-3">
                <div class="card-body">
                  <h2 class="card-title">Manage Users</h2>
                  <div class="table-responsive">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>Name</th>
                          <th>Position</th>
                          <th>Office</th>
                          <th>Age</th>
                          <th>Start Date</th>
                          <th>Assign</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Airi Satou</td>
                          <td>Accountant</td>
                          <td>Tokyo</td>
                          <td>55</td>
                          <td>2009/10/09</td>
                          <td>$162,700</td>
                        </tr>
                        <tr>
                          <td>Angelica Ramos</td>
                          <td>Chief Executive Officer (CEO)</td>
                          <td>London</td>
                          <td>30</td>
                          <td>2009/10/09</td>
                          <td>$190,500</td>
                        </tr>
                        <tr>
                          <td>Ashton Cox</td>
                          <td>Regional Director</td>
                          <td>San Francisco</td>
                          <td>36</td>
                          <td>2004/12/02</td>
                          <td>$62,700</td>
                        </tr>
                        <tr>
                          <td>Angelica Ramos</td>
                          <td>Chief Executive Officer (CEO)</td>
                          <td>London</td>
                          <td>30</td>
                          <td>2011/07/25</td>
                          <td>$190,500</td>
                        </tr>
                        <tr>
                          <td>Ashton Cox</td>
                          <td>Regional Director</td>
                          <td>San Francisco</td>
                          <td>32</td>
                          <td>2004/12/02</td>
                          <td>$62,700</td>
                        </tr>
                        <tr>
                          <td>Angelica Ramos</td>
                          <td>Chief Executive Officer (CEO)</td>
                          <td>London</td>
                          <td>31</td>
                          <td>2011/07/25</td>
                          <td>$190,500</td>
                        </tr>
                        <tr>
                          <td>Ashton Cox</td>
                          <td>Regional Director</td>
                          <td>Tokyo</td>
                          <td>39</td>
                          <td>2004/12/02</td>
                          <td>$62,700</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="d-flex align-items-center justify-content-between flex-wrap">
                    <p class="mb-0">Showing 1 to 10 of 57 entries</p>
                    <nav>
                      <ul class="pagination rounded-separated pagination-info mt-3">
                        <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-left"></i></a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-right"></i></a></li>
                      </ul>
                    </nav>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ROW ENDS -->
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../resources/partials/_footer.html -->
        <footer class="footer">
          <div class="container-fluid clearfix">
            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2018 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- row-offcanvas ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../resources/node_modules/jquery/dist/jquery.min.js"></script>
  <script src="../resources/node_modules/popper.js/dist/umd/popper.min.js"></script>
  <script src="../resources/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="../resources/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="../resources/node_modules/flot/jquery.flot.js"></script>
  <script src="../resources/node_modules/flot/jquery.flot.resize.js"></script>
  <script src="../resources/node_modules/flot.curvedlines/curvedLines.js"></script>
  <script src="../resources/node_modules/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
  <script src="../resources/node_modules/bootstrap-table/dist/bootstrap-table.min.js"></script>
  <script src="../resources/node_modules/jvectormap/jquery-jvectormap.min.js"></script>
  <script src="../resources/node_modules/jvectormap/tests/assets/jquery-jvectormap-world-mill-en.js"></script>
  <script src="../resources/node_modules/chartist/dist/chartist.min.js"></script>
  <script src="../resources/node_modules/progressbar.js/dist/progressbar.min.js"></script>
  <script src="../resources/node_modules/chartist-plugin-legend/chartist-plugin-legend.js"></script>
  <script src="../resources/node_modules/chart.js/dist/Chart.min.js"></script>
  <script src="../resources/node_modules/d3/d3.min.js"></script>
  <script src="../resources/node_modules/c3/c3.min.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../resources/js/off-canvas.js"></script>
  <script src="../resources/js/hoverable-collapse.js"></script>
  <script src="../resources/js/misc.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="../resources/js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
