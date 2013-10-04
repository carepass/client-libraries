package com.aetna.carepass.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Build;

/**
 * Generic support methods.
 */
class Utils {

	/**
	 * Reads all of an input stream into a string and closes the stream.
	 * Throws an io exception if an exception occurred during parsing.
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String readAllAndClose(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			try {
				for(;;) {
					String nextLine = reader.readLine();
					if(null==nextLine) break;
					sb.append(nextLine);
				} 
				return sb.toString();
			} finally {
				reader.close();
			}
		} catch(IOException e) {
			if (0 < sb.length()) {
				if(Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
					throw new PartialReadIOException(sb.toString(),
							e.getMessage());
				}
				throw new PartialReadIOException(sb.toString(), e);
			}
			throw e;
		} finally {
			inputStream.close();
		}
	}
}
