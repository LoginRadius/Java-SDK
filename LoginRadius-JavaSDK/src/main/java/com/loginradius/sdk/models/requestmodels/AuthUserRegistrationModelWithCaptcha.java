/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Auth User Registration by Recaptcha API
	 */
	public class AuthUserRegistrationModelWithCaptcha extends AuthUserRegistrationModel {
	
		
		@SerializedName("g-recaptcha-response")
        private String g_recaptcha_response;
		
		@SerializedName("qq_captcha_randstr")
        private String qq_captcha_randstr;
		
		@SerializedName("qq_captcha_ticket")
        private String qq_captcha_ticket;
		
		@SerializedName("recaptcha_challenge_field")
        private String recaptcha_challenge_field;
		
		@SerializedName("recaptcha_response_field")
        private String recaptcha_response_field;



		/**
		 * The acknowledgement received by Google in Google recaptcha authorisation process.
		 */
		public String getG_Recaptcha_Response() {
			return g_recaptcha_response;
		}
		/**
		 * The acknowledgement received by Google in Google recaptcha authorisation process.
		 */
		public void setG_Recaptcha_Response(String g_recaptcha_response) {
			this.g_recaptcha_response = g_recaptcha_response;
		}
		/**
		 * the value of the user's random string retrieved from the QQ captcha
		 */
		public String getQq_Captcha_Randstr() {
			return qq_captcha_randstr;
		}
		/**
		 * the value of the user's random string retrieved from the QQ captcha
		 */
		public void setQq_Captcha_Randstr(String qq_captcha_randstr) {
			this.qq_captcha_randstr = qq_captcha_randstr;
		}
		/**
		 * QQ Captcha ticket received from QQ in the QQ Captcha authorization process
		 */
		public String getQq_Captcha_Ticket() {
			return qq_captcha_ticket;
		}
		/**
		 * QQ Captcha ticket received from QQ in the QQ Captcha authorization process
		 */
		public void setQq_Captcha_Ticket(String qq_captcha_ticket) {
			this.qq_captcha_ticket = qq_captcha_ticket;
		}
		/**
		 * V1 recaptcha field (optional in case of V2 recaptcha)
		 */
		public String getRecaptcha_challenge_field() {
			return recaptcha_challenge_field;
		}
		/**
		 * V1 recaptcha field (optional in case of V2 recaptcha)
		 */
		public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
			this.recaptcha_challenge_field = recaptcha_challenge_field;
		}
		/**
		 * V1 recaptcha field (optional in case of V2 recaptcha)
		 */
		public String getRecaptcha_response_field() {
			return recaptcha_response_field;
		}
		/**
		 * V1 recaptcha field (optional in case of V2 recaptcha)
		 */
		public void setRecaptcha_response_field(String recaptcha_response_field) {
			this.recaptcha_response_field = recaptcha_response_field;
		}
    }