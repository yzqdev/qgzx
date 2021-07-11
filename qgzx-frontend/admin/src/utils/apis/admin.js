import axios from "@/utils/axios";
// 网站信息
export const adminReg = (data) => {
  return axios.post("/admin/reg", data);
};
export const adminLogin = (data) => {
  return axios.post("/admin/login", data);
};
export const updateAdmin = (data) => {
  return axios.put("/admin/updateAdmin", data);
};
export const delAdmin = (id) => {
  return axios.delete("/admin/deleteAdmin/" + id);
};
export const getAllAdmin = (isSuper) => {
  return axios.get("/admin/getAllAdmins?isSuper=" + isSuper);
};
