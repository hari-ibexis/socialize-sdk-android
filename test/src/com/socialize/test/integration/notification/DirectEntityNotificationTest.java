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
package com.socialize.test.integration.notification;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import com.socialize.Socialize;
import com.socialize.entity.Entity;
import com.socialize.launcher.LaunchAction;
import com.socialize.notifications.NotificationType;
import com.socialize.test.ui.util.TestUtils;


/**
 * @author Jason Polites
 *
 */
public class DirectEntityNotificationTest extends C2DMSimulationTest {
	
	private long entityId = -1;
	
	// https://docs.google.com/a/getsocialize.com/document/d/1KlsIM4VFyNkJY7g4E9VdH3rv_FxuNJhn3VCiStWGyEY/edit?authkey=CK223CU#heading=h.t8xa2p6i4big
	@Override
	protected JSONObject getNotificationMessagePacket() throws JSONException, IOException {
		JSONObject data = new JSONObject();
		data.put("message", "Test DirectEntity message");
		data.put("entity_id", getEntityId());
		data.put("source", "socialize");
		data.put("notification_type", NotificationType.DEVELOPER_DIRECT_ENTITY.name().toLowerCase());
		return data;
	}
	
	@Override
	protected void assertNotificationBundle(Bundle extras) throws IOException, JSONException {
		Entity entity = (Entity)extras.getSerializable(Socialize.ENTITY_OBJECT);
		assertNotNull(entity);
		assertEquals(getEntityId(), entity.getId().longValue());
	}

	/**
	 * Loads an entity from the JSON file written to disk after the initial python setup script (sdk-cleanup.py)
	 * @return
	 * @throws IOException 
	 * @throws JSONException 
	 */
	protected long getEntityId() throws IOException, JSONException {
		if(entityId < 0) {
			InputStream in = null;
			try {
				in = getContext().getAssets().open("existing-data/entities.json");
				String json = TestUtils.loadStream(in);
				JSONObject obj = new JSONObject(json);
				JSONArray jsonArray = obj.getJSONArray("items");
				entityId = jsonArray.getJSONObject(0).getLong("id");
			}
			finally {
				if(in != null) {
					in.close();
				}
			}
		}
		
		return entityId;
	}

	@Override
	protected LaunchAction getExpectedLaunchAction() {
		return LaunchAction.ENTITY;
	}
	
	@Override
	protected String getLauncherBeanName() {
		return "entityLauncher";
	}
}
