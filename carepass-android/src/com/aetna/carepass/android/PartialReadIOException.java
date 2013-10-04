package com.aetna.carepass.android;

import java.io.IOException;

import android.annotation.TargetApi;
import android.os.Build;

/**
 * An exception occurred while 
 * {@link Utils#readAllAndClose(java.io.InputStream) reading to a `String`} and
 * this returns what has been read so far.
 */
public class PartialReadIOException extends IOException {
	private static final long serialVersionUID = 1L;
	
	protected final String content;

	public PartialReadIOException(String content, String cause) {
		super(cause);
		this.content = content;
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public PartialReadIOException(String content, Throwable cause) {
		super("IO error while parsing to string: " + cause.getMessage(), cause);
		this.content = content;
	}
	/**
	 * Gets the content that was read in before the exception.
	 * @return the partial file content
	 */
	public String getContent() {
		return content;
	}
}
