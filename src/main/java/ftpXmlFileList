/**
 *
 * @param   FTP_IP, FTP_PORT, FTP_ID, FTP_PWD, FTP_PWD, 사용자ID
 * @return  FileList Set<String>
 */
public static Set<String> listFiles(String ip, int port, String id, String pw, String path, String userId) {
  FTPClient ftp = null;
	Set<String> rtn = new HashSet();
	try {
		ftp = new FTPClient(); //FTP 
		if (!connect(ftp, ip, port, id, pw, BINARY_MODE)) {
			return null; //연결이 실패하면 null를 리턴해줌.
		}
		FTPFile[] files = ftp.listFiles(path);
		for (FTPFile file : files) {
			if(file.getName().contains("_")){
				
			}else{
				ftp.rename(path+"/"+file.getName(),path+"/"+userId+"_"+file.getName());
			} //FTPClient의 rename을 이용하면 서버의 파일명을 변경할수 있다.
		}
		
		files = ftp.listFiles(path);
		for (FTPFile file : files) {
			int chr = file.getName().indexOf("_");
			if(file.getName().substring(0,chr).equals(userId)){
				rtn.add(file.getName());
			}
		} // 여긴 내가 파일을 구분해야해서 추가한 부분. 없어도 된다.
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
		try {
			disconnect(ftp);
		} catch (Exception ignore) {
		}
	}
	return rtn;
}
