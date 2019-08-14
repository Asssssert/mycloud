// const localhost = 'http://120.78.178.136';
const localhost = 'http://192.168.69.67';
const port = '8081';
const baseUrl = localhost + ":" + port;
const api = {
  login: `${baseUrl}/login/login`,
  accountList: `${baseUrl}/account/list`,
  accountAdd: `${baseUrl}/account/add`,
  accountDel: `${baseUrl}/account/del`,
  accountLock: `${baseUrl}/account/lock`,
  accountUpd: `${baseUrl}/account/upd`,
  accountGet: `${baseUrl}/account/get`,
  roleList: `${baseUrl}/role/list`,
  roleAdd: `${baseUrl}/role/add`,
  roleDel: `${baseUrl}/role/del`,
  roleUpd: `${baseUrl}/role/upd`,
  roleGet: `${baseUrl}/role/get`,
  permissionList: `${baseUrl}/permission/list`,
  permissionListType: `${baseUrl}/permission/list/type`,
  permissionListPid: `${baseUrl}/permission/list/pid`,
  permissionAdd: `${baseUrl}/permission/add`,
  permissionDel: `${baseUrl}/permission/del`,
  permissionUpd: `${baseUrl}/permission/upd`,
  permissionGet: `${baseUrl}/permission/get`,
};
module.exports = api;
