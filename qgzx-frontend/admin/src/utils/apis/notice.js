import axios from "@/utils/axios";
// 网站信息
export const addNotice = (data) => {
    return axios.post("/addNotice", data);
};
export const updateNotice = (data) => {
    return axios.put("/updateNotice", data);
};
export const getNoticeById = (data) => {
    return axios.get("/getNoticeById/" + data);
};
export const getAllNotices = () => {
    return axios.get("/getAllNotices");
};
export const deleteNoticeById = (data) => {
    return axios.delete("/deleteNotice/" + data);
};
