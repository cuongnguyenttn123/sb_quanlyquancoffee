package com.thecoffeshop.DTO;

import com.thecoffeshop.entity.Material;

public class MaterialDTO {

	private Material material;

	private Boolean canDelete;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}
	
	

}
