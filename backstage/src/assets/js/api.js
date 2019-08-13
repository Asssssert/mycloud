// const localhost = 'http://120.78.178.136';
const localhost = 'http://localhost';
const port = '8081';
const baseUrl = localhost + ":" + port;
const api = {
  login: `${baseUrl}/login/login`,
};
module.exports = api;
