/*
 * The MIT License
 *
 * Copyright (c) 2013 Petar Petrov
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
package net.vexelon.myglob.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import android.content.Context;
import net.vexelon.mobileops.HttpClientException;
import net.vexelon.mobileops.IClient;
import net.vexelon.myglob.users.User;

public class InvoiceUpdateAction extends BaseAction {
	
	public InvoiceUpdateAction(Context context, User user) {
		super(context, user);
	}

	@Override
	public ActionResult execute() throws ActionExecuteException {
		ActionResult result = new ActionResult();
		result.setCheckedOn(new Date());
		
		IClient client = newClient();
		clientLogin(client);
		
		try {
			List<Map<String, String>> invoiceInfo = client.getInvoiceInfo();
			result.setBytesCount(client.getDownloadedBytesCount());
			result.setResult(invoiceInfo);
			// update user info
			updateUserResult(result);
			
		} catch (HttpClientException e) {
			throw new ActionExecuteException(e);
		} finally {
			// Make sure we (attempt to) logout.
			clientLogout(client);
		}
		
		return result;
	}

}
