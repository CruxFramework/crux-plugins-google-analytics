package org.cruxframework.crux.plugin.google.analytics.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;

/**
 * Google Analytics API wrapper. You must call init once, informing your user account string
 * @author Thiago da Rosa de Bustamante
 *
 */
public class GoogleAnalytics
{
	private static boolean initialized = false;
	
	
	public static boolean isInitialized()
	{
		return initialized;
	}
	
	/**
	 * This method must be called once in your application, to initialize the google analytics api script.
	 * @param userAccount
	 */
	public static void init(String userAccount) 
	{
		assert (!initialized):"Google Analytics API was already initialized.";
		Element firstScript = Document.get().getElementsByTagName("script").getItem(0);

		ScriptElement config = Document.get().createScriptElement(
				"var _gaq = _gaq || [];_gaq.push(['_setAccount', '" + userAccount
				+ "']);_gaq.push(['_trackPageview']);");

		firstScript.getParentNode().insertBefore(config, firstScript);
		ScriptElement script = Document.get().createScriptElement();

		script.setSrc(("https:".equals(Window.Location.getProtocol())
				? "https://ssl" : "http://www") + ".google-analytics.com/ga.js");
		script.setType("text/javascript");
		script.setAttribute("async", "true");
		firstScript.getParentNode().insertBefore(script, firstScript);
		initialized = true;
	}

	/**
	 * 
	 * @param trackerName
	 * @param userAccount
	 */
	public static void addAccount(String trackerName, String userAccount)
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		addAccountNative(trackerName, userAccount);
	}
	
	/**
	 * 
	 * @param pageName
	 */
	public static void trackPageview(String pageName) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackPageviewNative(pageName);
	}

	/**
	 * 
	 */
	public static void trackPageview() 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackPageviewNative();
	}

	/**
	 * 
	 * @param trackerName
	 * @param pageName
	 */
	public static void trackPageview(String trackerName, String pageName) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackPageviewNative(trackerName, pageName);
	}

	/**
	 * 
	 * @param category
	 * @param action
	 */
	public static  void trackEvent(String category, String action) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventNative(category, action);
	}

	/**
	 * 
	 * @param category
	 * @param action
	 * @param optLabel
	 */
	public static void trackEvent(String category, String action, String optLabel) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventNative(category, action, optLabel);
	}

	/**
	 * 
	 * @param category
	 * @param action
	 * @param optLabel
	 * @param optValue
	 */
	public static void trackEvent(String category, String action, String optLabel, int optValue) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventNative(category, action, optLabel, optValue);
	}

	/**
	 * 
	 * @param category
	 * @param action
	 * @param optLabel
	 * @param optValue
	 * @param optNonInteraction
	 */
	public static void trackEvent(String category, String action, String optLabel, int optValue, boolean optNonInteraction) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventNative(category, action, optLabel, optValue, optNonInteraction);
	}

	/**
	 * 
	 * @param trackerName
	 * @param category
	 * @param action
	 */
	public static void trackEventWithTracker(String trackerName, String category, String action) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventWithTrackerNative(trackerName, category, action);
	}

	/**
	 * 
	 * @param trackerName
	 * @param category
	 * @param action
	 * @param optLabel
	 */
	public static void trackEventWithTracker(String trackerName, String category, String action, String optLabel) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventWithTrackerNative(trackerName, category, action, optLabel);
	}

	/**
	 * 
	 * @param trackerName
	 * @param category
	 * @param action
	 * @param optLabel
	 * @param optValue
	 */
	public static void trackEventWithTracker(String trackerName, String category, String action,
			String optLabel, int optValue) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventWithTrackerNative(trackerName, category, action, optLabel, optValue);
	}

	/**
	 * 
	 * @param trackerName
	 * @param category
	 * @param action
	 * @param optLabel
	 * @param optValue
	 * @param optNonInteraction
	 */
	public static void trackEventWithTracker(String trackerName, String category, String action, String optLabel, 
			int optValue, boolean optNonInteraction) 
	{
		assert (initialized):"Google Analytics API was not initialized. Call init(userAccount) method first";
		trackEventWithTrackerNative(trackerName, category, action, optLabel, optValue, optNonInteraction);
	}

	private static native void trackPageviewNative(String pageName) /*-{
	    if (!pageName.match("^/") == "/") {
	      pageName = "/" + pageName;
	    }

	    $wnd._gaq.push([ '_trackPageview', pageName ]);
	}-*/;

	private static native void addAccountNative(String trackerName, String userAccount) /*-{
	    $wnd._gaq.push([ '" + trackerName + "._setAccount', '" + userAccount + "' ]);
	}-*/;
	
	private static native void trackPageviewNative() /*-{
	    $wnd._gaq.push([ '_trackPageview' ]);
	}-*/;
	
	private static native void trackPageviewNative(String trackerName, String pageName) /*-{
	    if (!pageName.match("^/") == "/") {
	      pageName = "/" + pageName;
	    }

	    $wnd._gaq.push([ '" + trackerName + "._trackPageview', pageName ]);
	}-*/;
	
	private static native void trackEventNative(String category, String action) /*-{
	    $wnd._gaq.push([ '_trackEvent', category, action ]);
	}-*/;
	
	private static native void trackEventNative(String category, String action, String optLabel) /*-{
	    $wnd._gaq.push([ '_trackEvent', category, action, optLabel ]);
	}-*/;

	private static native void trackEventNative(String category, String action, String optLabel, int optValue) /*-{
	    $wnd._gaq.push([ '_trackEvent', category, action, optLabel, optValue ]);
	}-*/;
	
	private static native void trackEventNative(String category, String action, String optLabel, int optValue, boolean optNonInteraction) /*-{
	    $wnd._gaq.push([ '_trackEvent', category, action, optLabel, optValue, optNonInteraction ]);
	}-*/;
	
	private static native void trackEventWithTrackerNative(String trackerName, String category, String action) /*-{
	    $wnd._gaq.push([ '" + trackerName + "._trackEvent', category, action ]);
	}-*/;
	
	private native static void trackEventWithTrackerNative(String trackerName, String category, String action, String optLabel) /*-{
	    $wnd._gaq.push([ '" + trackerName + "._trackEvent', category, action, optLabel ]);
	}-*/;
	
	private static native void trackEventWithTrackerNative(String trackerName, String category, String action,
			String optLabel, int optValue) /*-{
	    $wnd._gaq.push([ '" + trackerName + "._trackEvent', category, action, optLabel, optValue ]);
	}-*/;
	
	private static native void trackEventWithTrackerNative(String trackerName, String category, String action, String optLabel, 
			int optValue, boolean optNonInteraction) /*-{
	    $wnd._gaq.push([ '" + trackerName + "._trackEvent', category, action, optLabel, optValue, optNonInteraction ]);
	}-*/;
}