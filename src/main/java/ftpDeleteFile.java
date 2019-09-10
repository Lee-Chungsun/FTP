/**
 * @param  ip, port, id, pwd, path, 
 * @return boolean deleteYN
 */
public static boolean deleteXml(String host, int port, String id, String pwd, String path, String file) {
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
			if (!connect(ftp, host, port, id, pwd, BINARY_MODE)) {
			return false;
		}
		ftp.deleteFile(path + "/" + file);
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
		try {
			disconnect(ftp);
		} catch (Exception ignore) {
		}
	}
	return true;
}
