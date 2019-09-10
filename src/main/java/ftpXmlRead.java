/**
 *
 * @param  ip, port, id, pwd, 파일 path, 파일명
 * @return 
 */
public static String receiveXml(String host, int port, String id, String pwd, String path, String file) {
	FTPClient ftp = null;
	InputStream in = null;
	ByteArrayOutputStream outputStream = null;	
	try {
		ftp = new FTPClient();
		
		if (!connect(ftp, host, port, id, pwd, BINARY_MODE)) {
			return null;
		}
		outputStream = new ByteArrayOutputStream();
		ftp.retrieveFile(path + "/" + file, outputStream);
		in = new ByteArrayInputStream(outputStream.toByteArray());
		//in = ftp.retrieveFileStream(path + "/" + file);
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
		try {
			if (outputStream != null) outputStream.close();
			if (in != null) in.close();
			disconnect(ftp);
		} catch (Exception ignore) {
		}
	}
	String rtn = null;
	try {
		rtn = StreamUtils.copyToString(in, Charset.defaultCharset());
	} catch (IOException e) {
		throw new RuntimeException(e);
	} finally {
		try {
			if (outputStream != null) outputStream.close();
			if (in != null) in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	return rtn;
}
