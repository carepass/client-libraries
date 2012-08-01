package com.aetna.carepass.oauth.connector.service.endpoints;

import com.aetna.carepass.oauth.connector.api.identity.Identity;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface IdentityService {

	public Identity findIdentity() throws EndpointException;
}
