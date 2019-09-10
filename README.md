# FTP
# FTPClient 라이브러리

1. rename - ftp 서버의 파일명 이름 변경 패스를 함께 입력해야하는데 패스를 변경하면 
            파일을 이동시킬수도 있다
ftp.rename(path + "/" + oldfilename, path(변경가능) + "/" + newfilename);

2. changeToParentDirectory - 현재 폴더에서 상위폴더로 이동
ftp.changeToParentDirectory();

3. printWorkingDirectory - 현재 작업중인 폴더 경로
ftp.printWorkingDirectory();

4. makeDirectory - 현재 폴더에서 디렉토리 생성
ftpClient.makeDirectory(dirname);

5. changeWorkingDirectory - 해당 폴더 경로로 이동
ftp.changeWorkingDirectory(path);

6. listFiles - 해당 폴더 경로에 있는 파일명을 FTPFile[] 타입으로 리턴
ftp.listFiles(path);

7. deleteFile - 해당 파일 삭제
ftp.deleteFile(path + "/" + file);
