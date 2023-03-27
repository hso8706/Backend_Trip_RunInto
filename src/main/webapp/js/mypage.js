function mypageSet() {
  let navId = document.getElementById('navId').value;
  let navName = document.getElementById('navName').value;
  let navPwd = document.getElementById('navPwd').value;
  let navPwCheck = document.getElementById('navPwCheck').value;

  localStorage.setItem(1, navName);
  localStorage.setItem(2, navId);
  localStorage.setItem(3, navPwd);
  localStorage.setItem(4, navPwCheck);

  alert("회원가입과 로그인이 완료되었습니다!");
}
function logout() {
  localStorage.clear();
}
