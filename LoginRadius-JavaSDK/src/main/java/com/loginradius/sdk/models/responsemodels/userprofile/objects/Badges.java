/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Badges data
	 */
	public class Badges {
	
		
		@SerializedName("BadgeId")
        private String badgeId;
		
		@SerializedName("BadgeMessage")
        private String badgeMessage;
		
		@SerializedName("BageId")
        private String bageId;
		
		@SerializedName("BageMessage")
        private String bageMessage;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Badge ID
		 */
		public String getBadgeId() {
			return badgeId;
		}
		/**
		 * Badge ID
		 */
		public void setBadgeId(String badgeId) {
			this.badgeId = badgeId;
		}
		/**
		 * Badge Message
		 */
		public String getBadgeMessage() {
			return badgeMessage;
		}
		/**
		 * Badge Message
		 */
		public void setBadgeMessage(String badgeMessage) {
			this.badgeMessage = badgeMessage;
		}
		/**
		 * Badge ID
		 */
		public String getBageId() {
			return bageId;
		}
		/**
		 * Badge ID
		 */
		public void setBageId(String bageId) {
			this.bageId = bageId;
		}
		/**
		 * Badge Message
		 */
		public String getBageMessage() {
			return bageMessage;
		}
		/**
		 * Badge Message
		 */
		public void setBageMessage(String bageMessage) {
			this.bageMessage = bageMessage;
		}
		/**
		 * detailed information
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * detailed information
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 * Badge Name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Badge Name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }