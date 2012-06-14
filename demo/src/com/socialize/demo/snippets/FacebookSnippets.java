/*
 * Copyright (c) 2012 Socialize Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.demo.snippets;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import android.app.Activity;
import com.socialize.ConfigUtils;
import com.socialize.ShareUtils;
import com.socialize.api.SocializeSession;
import com.socialize.api.action.share.ShareOptions;
import com.socialize.entity.Entity;
import com.socialize.entity.PropagationInfo;
import com.socialize.entity.PropagationInfoResponse;
import com.socialize.entity.Share;
import com.socialize.error.SocializeException;
import com.socialize.listener.SocializeAuthListener;
import com.socialize.listener.share.ShareAddListener;
import com.socialize.networks.PostData;
import com.socialize.networks.SocialNetwork;
import com.socialize.networks.SocialNetworkListener;
import com.socialize.networks.facebook.FacebookUtils;


/**
 * @author Jason Polites
 *
 */
public class FacebookSnippets extends Activity {
public void linkFB() {
// begin-snippet-0
FacebookUtils.link(this, new SocializeAuthListener() {

	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAuthSuccess(SocializeSession session) {
		// User was authed.
	}
	
	@Override
	public void onAuthFail(SocializeException error) {
		// Handle error
	}
	
	@Override
	public void onError(SocializeException error) {
		// Handle error
	}
});
// end-snippet-0
}

public void linkFBWithToken() {
// begin-snippet-1
// The user's Facebook auth token
String fbToken = "ABCDEF...GHIJKL";

FacebookUtils.link(this, fbToken, new SocializeAuthListener() {

	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAuthSuccess(SocializeSession session) {
		// User was authed.
	}
	
	@Override
	public void onAuthFail(SocializeException error) {
		// Handle error
	}
	
	@Override
	public void onError(SocializeException error) {
		// Handle error
	}
});
// end-snippet-1
}

public void setSingleSignOn() {
// begin-snippet-2
// Disable ONLY if you experience problems
ConfigUtils.getConfig(this).setFacebookSingleSignOnEnabled(false);	
// end-snippet-2
}
public void unlink() {
// begin-snippet-3
// Disconnect the user from their Facebook account
FacebookUtils.unlink(this);	
// end-snippet-3
}

public void postEntity() {
// begin-snippet-4
Entity entity = Entity.newInstance("http://myentity.com", "My Name");
	
FacebookUtils.postEntity(this, entity, "Text to be posted", new SocialNetworkListener() {
	
	@Override
	public void onNetworkError(Activity context, SocialNetwork network, Exception error) {
		// Handle error
	}
	
	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAfterPost(Activity parent, SocialNetwork socialNetwork, JSONObject responseObject) {
		// Called after the post returned from Facebook.
		// responseObject contains the raw JSON response from Facebook.
	}
	
	@Override
	public void onBeforePost(Activity parent, SocialNetwork socialNetwork, PostData postData) {
		// Called just prior to the post.
		// postData contains the dictionary (map) of data to be posted.  
		// You can change this here to customize the post.
	}
});
// end-snippet-4
}


public void post() {
// begin-snippet-5
// The graph API path to be called
String graphPath = "me/links";

// The data to be posted. This is based on the graphPath
// See http://developers.facebook.com/docs/reference/api/
Map<String, Object> postData = new HashMap<String, Object>();
postData.put("message", "A message to post");
postData.put("link", "http://getsocialize.com");
postData.put("name", "Socialize SDK!");
	
// Execute a POST on facebook
FacebookUtils.post(this, graphPath, postData, new SocialNetworkListener() {
	
	@Override
	public void onNetworkError(Activity context, SocialNetwork network, Exception error) {
		// Handle error
	}
	
	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAfterPost(Activity parent, SocialNetwork socialNetwork, JSONObject responseObject) {
		// Called after the post returned from Facebook.
		// responseObject contains the raw JSON response from Facebook.
	}
	
	@Override
	public void onBeforePost(Activity parent, SocialNetwork socialNetwork, PostData postData) {
		// Called just prior to the post.
	}
});
// end-snippet-5
}

public void get() {
// begin-snippet-6
// The graph API path to be called
String graphPath = "me/links";

// Execute a GET on facebook
FacebookUtils.get(this, graphPath, null, new SocialNetworkListener() {
	
	@Override
	public void onNetworkError(Activity context, SocialNetwork network, Exception error) {
		// Handle error
	}
	
	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAfterPost(Activity parent, SocialNetwork socialNetwork, JSONObject responseObject) {
		// Called after the post returned from Facebook.
		// responseObject contains the raw JSON response from Facebook.
	}
	
	@Override
	public void onBeforePost(Activity parent, SocialNetwork socialNetwork, PostData postData) {
		// Called just prior to the post.
	}
});
// end-snippet-6
}


public void delete() {
// begin-snippet-7
// The graph API path to be called
String graphPath = "me/links/1234";

// Execute a DELETE on facebook
FacebookUtils.delete(this, graphPath, null, new SocialNetworkListener() {
	
	@Override
	public void onNetworkError(Activity context, SocialNetwork network, Exception error) {
		// Handle error
	}
	
	@Override
	public void onCancel() {
		// The user cancelled the operation.
	}
	
	@Override
	public void onAfterPost(Activity parent, SocialNetwork socialNetwork, JSONObject responseObject) {
		// Called after the post returned from Facebook.
		// responseObject contains the raw JSON response from Facebook.
	}
	
	@Override
	public void onBeforePost(Activity parent, SocialNetwork socialNetwork, PostData postData) {
		// Called just prior to the post.
	}
});
// end-snippet-7
}




public void postWithUrl() {
final Activity context = this;
// begin-snippet-8
// Create a simple share object to get the propagation data
final Entity entity = Entity.newInstance("http://myentity.com", "My Name");

ShareOptions options = ShareUtils.getUserShareOptions(this);

ShareUtils.registerShare(this, entity, options, new ShareAddListener() {
	
	@Override
	public void onError(SocializeException error) {
		// Handle error
	}
	
	@Override
	public void onCreate(Share share) {
		
		// Get the propagation info from the result
		PropagationInfoResponse propagationInfoResponse = share.getPropagationInfoResponse();
		
		PropagationInfo propagationInfo = propagationInfoResponse.getPropagationInfo(SocialNetwork.FACEBOOK);
		
		// The graph API path to be called
		String graphPath = "me/links";

		// The data to be posted. This is based on the graphPath
		// See http://developers.facebook.com/docs/reference/api/
		Map<String, Object> postData = new HashMap<String, Object>();
		postData.put("message", "A message to post");
		postData.put("link", propagationInfo.getEntityUrl()); // Use the SmartDownload URL
		postData.put("name", entity.getDisplayName());
			
		// Execute a POST on facebook
		FacebookUtils.post(context, graphPath, postData, new SocialNetworkListener() {
			
			@Override
			public void onNetworkError(Activity context, SocialNetwork network, Exception error) {
				// Handle error
			}
			
			@Override
			public void onCancel() {
				// The user cancelled the operation.
			}
			
			@Override
			public void onAfterPost(Activity parent, SocialNetwork socialNetwork, JSONObject responseObject) {
				// Called after the post returned from Facebook.
				// responseObject contains the raw JSON response from Facebook.
			}
			
			@Override
			public void onBeforePost(Activity parent, SocialNetwork socialNetwork, PostData postData) {
				// Called just prior to the post.
			}
		});		
	}
}, SocialNetwork.FACEBOOK);
// end-snippet-8
}

}
