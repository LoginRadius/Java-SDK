/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.EventBasedMultiFactorToken;
import com.loginradius.sdk.models.requestmodels.PINAuthEventBasedAuthModelWithLockout;
import com.loginradius.sdk.models.requestmodels.PasswordEventBasedAuthModelWithLockout;
import com.loginradius.sdk.models.requestmodels.ReauthByBackupCodeModel;
import com.loginradius.sdk.models.requestmodels.ReauthByGoogleAuthenticatorCodeModel;
import com.loginradius.sdk.models.requestmodels.ReauthByOtpModel;
import com.loginradius.sdk.models.responsemodels.EventBasedMultiFactorAuthenticationToken;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationSettingsResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostValidationResponse;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class ReAuthenticationApi {
   private static Gson gson =new Gson();

   public ReAuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to trigger the Multi-Factor Autentication workflow for the provided access_token
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <returns>Response containing Definition of Complete Multi-Factor Authentication Settings data</returns>
   // 14.3	    
		
		
   public void mfaReAuthenticate(String accessToken, String smsTemplate2FA, final AsyncHandler<MultiFactorAuthenticationSettingsResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/account/reauth/2fa";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationSettingsResponse> typeToken = new TypeToken<MultiFactorAuthenticationSettingsResponse>() {};
          MultiFactorAuthenticationSettingsResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to re-authenticate via Multi-factor authentication by passing the One Time Password received via SMS
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="reauthByOtpModel">Model Class containing Definition for MFA Reauthentication by OTP</param>
   // <returns>Complete user Multi-Factor Authentication Token data</returns>
   // 14.4	    
		
		
   public void mfaReAuthenticateByOTP(String accessToken, ReauthByOtpModel reauthByOtpModel, final AsyncHandler<EventBasedMultiFactorAuthenticationToken> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (reauthByOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("reauthByOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/reauth/2fa/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(reauthByOtpModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EventBasedMultiFactorAuthenticationToken> typeToken = new TypeToken<EventBasedMultiFactorAuthenticationToken>() {};
          EventBasedMultiFactorAuthenticationToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to re-authenticate by set of backup codes via access_token on the site that has Multi-factor authentication enabled in re-authentication for the user that does not have the device
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="reauthByBackupCodeModel">Model Class containing Definition for MFA Reauthentication by Backup code</param>
   // <returns>Complete user Multi-Factor Authentication Token data</returns>
   // 14.5	    
		
		
   public void mfaReAuthenticateByBackupCode(String accessToken, ReauthByBackupCodeModel reauthByBackupCodeModel, final AsyncHandler<EventBasedMultiFactorAuthenticationToken> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (reauthByBackupCodeModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("reauthByBackupCodeModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/reauth/2fa/backupcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(reauthByBackupCodeModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EventBasedMultiFactorAuthenticationToken> typeToken = new TypeToken<EventBasedMultiFactorAuthenticationToken>() {};
          EventBasedMultiFactorAuthenticationToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to re-authenticate via Multi-factor-authentication by passing the google authenticator code
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="reauthByGoogleAuthenticatorCodeModel">Model Class containing Definition for MFA Reauthentication by Google Authenticator</param>
   // <returns>Complete user Multi-Factor Authentication Token data</returns>
   // 14.6	    
		
		
   public void mfaReAuthenticateByGoogleAuth(String accessToken, ReauthByGoogleAuthenticatorCodeModel reauthByGoogleAuthenticatorCodeModel, final AsyncHandler<EventBasedMultiFactorAuthenticationToken> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (reauthByGoogleAuthenticatorCodeModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("reauthByGoogleAuthenticatorCodeModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/reauth/2fa/googleauthenticatorcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(reauthByGoogleAuthenticatorCodeModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EventBasedMultiFactorAuthenticationToken> typeToken = new TypeToken<EventBasedMultiFactorAuthenticationToken>() {};
          EventBasedMultiFactorAuthenticationToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to re-authenticate via Multi-factor-authentication by passing the password
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="passwordEventBasedAuthModelWithLockout">Model Class containing Definition of payload for PasswordEventBasedAuthModel with Lockout API</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <returns>Complete user Multi-Factor Authentication Token data</returns>
   // 14.7	    
		
		
   public void mfaReAuthenticateByPassword(String accessToken, PasswordEventBasedAuthModelWithLockout passwordEventBasedAuthModelWithLockout,
      String smsTemplate2FA, final AsyncHandler<EventBasedMultiFactorAuthenticationToken> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (passwordEventBasedAuthModelWithLockout == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("passwordEventBasedAuthModelWithLockout"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/account/reauth/password";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(passwordEventBasedAuthModelWithLockout), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EventBasedMultiFactorAuthenticationToken> typeToken = new TypeToken<EventBasedMultiFactorAuthenticationToken>() {};
          EventBasedMultiFactorAuthenticationToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used on the server-side to validate and verify the re-authentication token created by the MFA re-authentication API. This API checks re-authentications created by OTP.
   // </summary>
   // <param name="eventBasedMultiFactorToken">Model Class containing Definition for SecondFactorValidationToken</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.38	    
		
		
   public void verifyMultiFactorOtpReauthentication(EventBasedMultiFactorToken eventBasedMultiFactorToken, String uid, final AsyncHandler<PostValidationResponse> handler) {

      if (eventBasedMultiFactorToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("eventBasedMultiFactorToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/reauth/2fa";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(eventBasedMultiFactorToken), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostValidationResponse> typeToken = new TypeToken<PostValidationResponse>() {};
          PostValidationResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used on the server-side to validate and verify the re-authentication token created by the MFA re-authentication API. This API checks re-authentications created by password.
   // </summary>
   // <param name="eventBasedMultiFactorToken">Model Class containing Definition for SecondFactorValidationToken</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.39	    
		
		
   public void verifyMultiFactorPasswordReauthentication(EventBasedMultiFactorToken eventBasedMultiFactorToken, String uid, final AsyncHandler<PostValidationResponse> handler) {

      if (eventBasedMultiFactorToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("eventBasedMultiFactorToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/reauth/password";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(eventBasedMultiFactorToken), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostValidationResponse> typeToken = new TypeToken<PostValidationResponse>() {};
          PostValidationResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used on the server-side to validate and verify the re-authentication token created by the MFA re-authentication API. This API checks re-authentications created by PIN.
   // </summary>
   // <param name="eventBasedMultiFactorToken">Model Class containing Definition for SecondFactorValidationToken</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.40	    
		
		
   public void verifyMultiFactorPINReauthentication(EventBasedMultiFactorToken eventBasedMultiFactorToken, String uid, final AsyncHandler<PostValidationResponse> handler) {

      if (eventBasedMultiFactorToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("eventBasedMultiFactorToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/reauth/pin";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(eventBasedMultiFactorToken), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostValidationResponse> typeToken = new TypeToken<PostValidationResponse>() {};
          PostValidationResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to validate the triggered MFA authentication flow with a password.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="pINAuthEventBasedAuthModelWithLockout">Model Class containing Definition of payload for PIN</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <returns>Response containing Definition response of MFA reauthentication</returns>
   // 42.13	    
		
		
   public void verifyPINAuthentication(String accessToken, PINAuthEventBasedAuthModelWithLockout pINAuthEventBasedAuthModelWithLockout,
      String smsTemplate2FA, final AsyncHandler<EventBasedMultiFactorAuthenticationToken> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (pINAuthEventBasedAuthModelWithLockout == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("pINAuthEventBasedAuthModelWithLockout"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/account/reauth/pin";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(pINAuthEventBasedAuthModelWithLockout), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EventBasedMultiFactorAuthenticationToken> typeToken = new TypeToken<EventBasedMultiFactorAuthenticationToken>() {};
          EventBasedMultiFactorAuthenticationToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
