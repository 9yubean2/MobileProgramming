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
    <h1>Insert New User</h1>
    <form action="insert.php" method="POST">
      <p>Name:<input type="text" name="userName" required></p>
      <p>Password:<input type="text" name="userPassword" required></p>
      <p>Age:<input type="number" name="userAge" required></p>
      <p>BirthDate:<input type="date" name="userBirthDate" placeholder="yyyy-mm-dd" required></p>
      <button>Insert</button>
    </form>
  </body>
</html>