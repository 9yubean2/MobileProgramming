<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Delete User</title>
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
      
    
      $jb_conn = mysqli_connect("dburl", "dbid", "dbpw", "dlrbqls3024_ts")or die("MySQL 접속 실패 !!");
      $jb_sql = "DELETE FROM userInfo WHERE userNum='".$userNum."'";
      $ret = mysqli_query( $jb_conn, $jb_sql );
      echo "<h1> Delete </h1>";
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
