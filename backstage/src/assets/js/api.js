// const localhost = 'http://120.78.178.136';
const localhost = 'http://localhost';
const port = '8081';
const baseUrl = localhost + ":" + port;
const api = {
  login: `${baseUrl}/login/login`,
  logout: `${baseUrl}/login/logout`,
  userInfo: `${baseUrl}/user/get/userInfo`,
  accountList: `${baseUrl}/account/list`,
  accountAdd: `${baseUrl}/account/add`,
  accountAddRole: `${baseUrl}/account/add/role`,
  accountDel: `${baseUrl}/account/del`,
  accountLock: `${baseUrl}/account/lock`,
  accountUpd: `${baseUrl}/account/upd`,
  accountGet: `${baseUrl}/account/get`,
  roleList: `${baseUrl}/role/list`,
  roleListAll: `${baseUrl}/role/list/all`,
  roleListByAid: `${baseUrl}/role/list/aid`,
  roleAdd: `${baseUrl}/role/add`,
  roleAddPermission: `${baseUrl}/role/add/permission`,
  roleDel: `${baseUrl}/role/del`,
  roleUpd: `${baseUrl}/role/upd`,
  roleGet: `${baseUrl}/role/get`,
  permissionList: `${baseUrl}/permission/list`,
  permissionListAll: `${baseUrl}/permission/list/all`,
  permissionListByRid: `${baseUrl}/permission/list/rid`,
  permissionListType: `${baseUrl}/permission/list/type`,
  permissionListPid: `${baseUrl}/permission/list/pid`,
  permissionAdd: `${baseUrl}/permission/add`,
  permissionDel: `${baseUrl}/permission/del`,
  permissionUpd: `${baseUrl}/permission/upd`,
  permissionGet: `${baseUrl}/permission/get`,
};
module.exports = api;
