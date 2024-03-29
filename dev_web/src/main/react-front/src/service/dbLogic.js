import axios from "axios";

export const boardListDB = (board) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_DEV_JSP_IP + "board3/jsonBoardList.st3",
        params: board,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};

export const uploadImageDB = (file) => {
  console.log(file);
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_DEV_JSP_IP + "board3/imageUpload.st3",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        processData: false,
        contentType: false,
        data: file,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};

export const boardInsertDB = (board) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_DEV_JSP_IP + "board3/boardInsert.st3",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data: board,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};

/* rafce 단축키 - arrow function export default*/
