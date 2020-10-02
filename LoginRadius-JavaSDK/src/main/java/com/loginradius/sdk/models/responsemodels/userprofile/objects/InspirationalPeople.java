/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Inspirational People data
	 */
	public class InspirationalPeople {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * ID of inspirational people
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of inspirational people
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * name of inspirational people
		 */
		public String getName() {
			return name;
		}
		/**
		 * name of inspirational people
		 */
		public void setName(String name) {
			this.name = name;
		}
    }