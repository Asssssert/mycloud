// const localhost = 'http://120.78.178.136';
const localhost = 'http://192.168.69.67';
const port = '8081';
const baseUrl = localhost + ":" + port;
const api = {
  login: `${baseUrl}/login/login`,
  accountList: `${baseUrl}/account/list`,
};
module.exports = api;
