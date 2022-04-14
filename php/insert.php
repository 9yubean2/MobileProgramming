<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Insert New User</title>
    <style>
      body {
        font-family: Consolas, monospace;
        font-family: 12px;
      }
    </style>
  </head>
  <body>
    <?php
      $userName = $_POST[ 'userName' ];
      $userPassword = $_POST[ 'userPassword' ];
      $userAge = $_POST[ 'userAge' ];
      $userBirtDate = $_POST[ 'userBirthDate' ];
      $createDate = date('Y-m-d H:i:s');
      $jb_conn = mysqli_connect("sc1.swu.ac.kr:13306", "dlrbqls3024", "dlrbqls302485", "dlrbqls3024_ts")or die("MySQL 접속 실패 !!");
      $jb_sql =" INSERT INTO userInfo (userPassword, userName, userAge, userBirthDate, createDate) VALUES('".$userPassword."','".$userName."',".$userAge.",'".$userBirtDate."','".$createDate."')";
      $ret = mysqli_query( $jb_conn, $jb_sql );
      echo "<h1> Insert </h1>";
      if($ret) {
          echo "Success.";
        }
        else {
            echo "Fail!!!"."<br>";
            echo "Caused :".mysqli_error($jb_conn);
        } 
        mysqli_close($jb_conn);
    ?>
  </body>
</html>