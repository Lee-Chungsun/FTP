/**
 *
 * @param : ftpClient 객체, IP, PORT, ID, PWD, FTP MODE
 */

private static boolean connect(FTPClient ftpClient, String ftp_ip, int ftp_port, String ftp_id, String ftp_pw, int ftp_mode) throws Exception {

	boolean result = false;

	ftpClient.connect(ftp_ip, ftp_port); // FTP 연결하기 위한 메서드
	int reply = ftpClient.getReplyCode();

	if (!FTPReply.isPositiveCompletion(reply)) {
		return false;
	}

	result = ftpClient.login(ftp_id, ftp_pw); // 로그인하기 위한 메서드
	if (!result) {
		return false;
	}

	ftpClient.enterLocalPassiveMode();
	ftpClient.setFileType(ftp_mode);

	return result;
}
