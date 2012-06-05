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
package com.socialize.api.action;

import com.socialize.networks.SocialNetwork;
import com.socialize.networks.SocialNetworkListener;


/**
 * Allows for the specification of options for sharing.
 * @author Jason Polites
 */
public class ActionOptions {
	
	private boolean shareLocation;
	
	@Deprecated
	private SocialNetwork[] shareTo;
	
	@Deprecated
	private SocialNetworkListener listener;
	
	private boolean selfManaged = false;
	private boolean authRequired = true;
	
	/**
	 * If true and if available, the user's location is shared.
	 * @return
	 */
	public boolean isShareLocation() {
		return shareLocation;
	}
	
	/**
	 * If true and if available, the user's location is shared.
	 * @param shareLocation
	 */
	public void setShareLocation(boolean shareLocation) {
		this.shareLocation = shareLocation;
	}
	
	@Deprecated
	public SocialNetwork[] getShareTo() {
		return shareTo;
	}

	@Deprecated
	public void setShareTo(SocialNetwork...shareTo) {
		this.shareTo = shareTo;
	}

	@Deprecated
	public SocialNetworkListener getListener() {
		return listener;
	}

	/**
	 * Allows for the capture of events when sharing on social networks like facebook.
	 * @param listener
	 */
	@Deprecated
	public void setListener(SocialNetworkListener listener) {
		this.listener = listener;
	}
	
	@Deprecated
	public boolean isShareTo(SocialNetwork destination) {
		if(shareTo != null) {
			for (SocialNetwork d : shareTo) {
				if(d.equals(destination)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isSelfManaged() {
		return selfManaged;
	}

	/**
	 * Set to true if the sharing to 3rd party networks will be handled by the client (default: false)
	 * @param selfManaged
	 */
	public void setSelfManaged(boolean selfManaged) {
		this.selfManaged = selfManaged;
	}
	
	public boolean isAuthRequired() {
		return authRequired;
	}

	/**
	 * Set to false if you DON'T want the authenticate dialog to show when sharing.
	 * Defaults to socialize.require.auth config property.
	 * @param requireAuth
	 */
	public void setAuthRequired(boolean requireAuth) {
		this.authRequired = requireAuth;
	}
	
	/**
	 * Used to merge legacy ShareOptions objects.
	 * @param other
	 */
	public void merge(ActionOptions other) {
		setAuthRequired(other.isAuthRequired());
		setSelfManaged(other.isSelfManaged());
		setShareLocation(other.isShareLocation());
		setListener(other.getListener());
		setShareTo(other.getShareTo());
	}
}