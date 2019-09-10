FTPClient ftp = null;
ftp = new FTPClient();
connect(ftp, ip, port, id, pw, BINARY_MODE);
FTPFile[] files = ftp.listFiles(path);

ftp.rename(path+"/"+file.getName(),path+"/"+userId+"_"+file.getName());
