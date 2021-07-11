import axios from "@/utils/axios";
// 网站信息
export const addJob = (data) => {
  return axios.post("/addJob", data);
};
export const updateJob = (data) => {
  return axios.put("/updateJob", data);
};
export const getJobById = (id) => {
  return axios.get("/getJobById/" + id);
};
export const getAllJobs = () => {
  return axios.get("/getAllJobs");
};
export const deleteJobById = (data) => {
  return axios.delete("/deleteJob/" + data);
};
