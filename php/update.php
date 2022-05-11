<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Update User</title>
    <style>
      body {
        font-family: Consolas, monospace;
        font-family: 12px;
      }
    </style>
  </head>
  <body>
    <?php
      $userNum = $_POST[ 'userNum' ];
      $userName = $_POST[ 'userName' ];
      $userPassword = $_POST[ 'userPassword' ];
      $userAge = $_POST[ 'userAge' ];
      $userBirthDate = $_POST[ 'userBirthDate' ];
    
      $jb_conn = mysqli_connect("dburl", "dbid", "dbpw", "dlrbqls3024_ts")or die("MySQL 접속 실패 !!");
      $jb_sql = "UPDATE userInfo SET userPassword='".$userPassword."', userName='".$userName."', userAge='".$userAge."', userBirthDate='".$userBirthDate."' WHERE userNum='".$userNum."'";
      $ret = mysqli_query( $jb_conn, $jb_sql );
      echo "<h1> Update </h1>";
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
