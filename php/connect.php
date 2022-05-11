<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Employees</title>
    <style>
      body {
        font-family: Consolas, monospace;
        font-family: 12px;
      }
      table {
        width: 100%;
      }
      th, td {
        padding: 10px;
        border-bottom: 1px solid #dadada;
      }
    </style>
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>userNum</th>
          <th>userPassword</th>
          <th>userName</th>
          <th>userAge</th>
          <th>userBirthDate</th>
          <th>createDate</th>
        </tr>
      </thead>
      <tbody>
        <?php
          $jb_conn = mysqli_connect( 'dburl', 'db id', 'db pw', 'dlrbqls3024_ts' );
          $jb_sql = "SELECT * FROM userInfo;";
          $jb_result = mysqli_query( $jb_conn, $jb_sql );
          while( $jb_row = mysqli_fetch_array( $jb_result ) ) {
            echo '<tr><td>' . $jb_row[ 'userNum' ].  '</td><td>'. $jb_row[ 'userPassword' ]. '</td><td>'. $jb_row[ 'userName' ] . '</td><td>' . $jb_row[ 'userAge' ] . '</td><td>' . $jb_row[ 'userBirthDate' ] . '</td><td>' . $jb_row[ 'createDate' ] . '</td></tr>';
          }
        ?>
      </tbody>
    </table>
  </body>
</html>
