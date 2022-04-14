<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Select User by JSON</title>
    <style>
      body {
        font-family: Consolas, monospace;
        font-family: 12px;
      }
    </style>
  </head>
  <body>
    <h1>Select User by JSON</h1>
    <form action="select_json.php" method="POST">
      <p>Name:<input type="text" name="userName_json" placeholder='{"name":"Write the name you are looking for"}' style="width:300px" required></p>
      
      <button>Search</button>
    </form>
  </body>
</html>