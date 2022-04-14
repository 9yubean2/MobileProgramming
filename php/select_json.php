<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Search User By JSON</title>
    <style>
      body {
        font-family: Consolas, monospace;
        font-family: 12px;
      }
    </style>
  </head>
  <body>
    <?php
      $userName_json = $_POST[ 'userName_json' ];
      //echo $userName_json;

      $arr = json_decode($userName_json,true);
      $userName_parsing = $arr["name"];
      //echo $userName_parsing;
      
      $jb_conn = mysqli_connect("sc1.swu.ac.kr:13306", "dlrbqls3024", "dlrbqls302485", "dlrbqls3024_ts")or die("MySQL 접속 실패 !!");
      $jb_sql ="SELECT * FROM userInfo WHERE userName='".$userName_parsing."'";
      $jb_result = mysqli_query( $jb_conn, $jb_sql );
      echo "<h1> Search </h1>";
      $resultArray = array ();

      if($jb_result) {
          while($jb_row = mysqli_fetch_assoc( $jb_result )){
            
            $middleArray = array (
                "userNum" => (int)$jb_row[ 'userNum'],
                "userPassword" => urlencode($jb_row[ 'userPassword']),
                "userName" => urlencode($jb_row[ 'userName']),
                "userAge" => (int)$jb_row[ 'userAge' ],
                "userBirthDate" =>  urlencode($jb_row[ 'userBirthDate' ]),
                "createDate" =>  urlencode($jb_row[ 'createDate' ])
            );
            array_push($resultArray,$middleArray);
            
          }
          echo ( urldecode ( json_encode ( $resultArray , JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE) ) );    
         
        }
        else {
            echo "Fail!!!"."<br>";
            echo "Caused :".mysqli_error($jb_conn);
        } 
        mysqli_close($jb_conn);
          
    ?>
  </body>
</html>