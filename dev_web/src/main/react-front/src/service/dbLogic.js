import React from "react";

export const jsonDeptList = (params) => {
  return new Promise((resolve, reject) => {
    try {
      const reaponse = axios({
        method: "get",
        url: process.env.REACT_APP_DEV_JSP_IP + "dept/jsonDeptList.st1",
        parmas: params,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};
