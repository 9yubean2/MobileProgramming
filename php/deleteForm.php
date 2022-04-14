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
    <h1>Delete User</h1>
    <form action="delete.php" method="POST">
        <p>Num:<input type="text" name="userNum" required></p >
      
      <button>Delete</button>
    </form>
  </body>
</html>