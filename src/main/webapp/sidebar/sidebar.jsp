<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Side Navbar - Tivotal</title>
    <link rel="stylesheet" href="sidebar/sidebar.css" />
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet"/>
    <link href="sidebar/sidebar.css" rel="stylesheet" />
  </head>
  <body>
    <section class="sidebar">
      <div class="nav-header">
        <p class="logo">Admin Page</p>
        <i class="bx bx-menu-alt-right btn-menu"></i>
      </div>
      <ul class="nav-links">
        <li>
          <i class="bx bx-search search-btn"></i>
          <input type="text" placeholder="search..." />
          <span class="tooltip">Search</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-home-alt-2"></i>
            <span class="title">Home</span>
          </a>
          <span class="tooltip">Home</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-phone-call"></i>
            <span class="title">Calls</span>
          </a>
          <span class="tooltip">Calls</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-bookmark"></i>
            <span class="title">Bookmarks</span>
          </a>
          <span class="tooltip">Bookmarks</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-wallet-alt"></i>
            <span class="title">Wallet</span>
          </a>
          <span class="tooltip">Wallet</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bxs-devices"></i>
            <span class="title">Devices</span>
          </a>
          <span class="tooltip">Devices</span>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-cog"></i>
            <span class="title">Setting</span>
          </a>
          <span class="tooltip">Setting</span>
        </li>
      </ul>
      <div class="theme-wrapper">
        <i class="bx bxs-moon theme-icon"></i>
        <p>Dark Theme</p>
        <div class="theme-btn">
          <span class="theme-ball"></span>
        </div>
      </div>
    </section>
    </div>
    <script src="sidebar/sidebar.js"></script>
  </body>
</html>    