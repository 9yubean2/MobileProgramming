<!doctype html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Output UserInfo</title>
        <style>
        body {
            font-family: Consolas, monospace;
            font-family: 12px;
        }
        </style>
    </head>
    <body>
        <?php
        $SearchWord = $_POST[ 'userName_json' ];
        $SearchWord_jason = json_decode($SearchWord,true);
        
        $UserName = $SearchWord_jason ["name"]; //배열 안에 name이 뜻하는건 앞에 form페이지에서 어떤 단어 뒤에걸 파싱할지 정하는 거에요!
    
        //$res = mysqli_query( $con, $jb_sql );
        $con = mysqli_connect("sc1.swu.ac.kr:13306", "dlrbqls3024", "dlrbqls302485", "dlrbqls3024_ts") or die("MySQL 접속실패");
        mysqli_set_charset($con,"utf8");
        $res = mysqli_query($con, "SELECT * FROM userInfo WHERE userName='$UserName'");
        echo "<h1> Search </h1>";
        $result = array();

        if($res) {
            while($row = mysqli_fetch_assoc($res)){
                
                array_push($result,array (
                    "userNum" => (int)$row[ 'userNum'],
                    "userPassword" => urlencode($row[ 'userPassword']),
                    "userName" => urlencode($row[ 'userName']),
                    "userAge" => (int)$row[ 'userAge' ],
                    "userBirthDate" =>  urlencode($row[ 'userBirthDate' ]),
                    "createDate" =>  urlencode($row[ 'createDate' ])
                ));
              
            }
            echo ( urldecode ( json_encode ( $result , JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE) ) );    
           
          }
          else {
              echo "Fail!!!"."<br>";
              echo "Caused :".mysqli_error($con);
          } 
        mysqli_close($con);
        
        ?>
    </body>
</html>