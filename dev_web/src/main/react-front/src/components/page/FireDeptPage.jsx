import React from 'react'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import { useState } from 'react'
import { Table } from 'react-bootstrap'
import { useEffect } from 'react'
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.17.1/firebase-app.js";
import {
  getDatabase,
  ref,
  set,
  onValue,
} from "https://www.gstatic.com/firebasejs/9.17.1/firebase-database.js";
import DeptRow from '../dept/DeptRow'
import { Navigate, useNavigate } from 'react-router-dom'

//db에서 데이터 가져와서 처리하기
const firebaseConfig = {
  apiKey: process.env.REACT_APP_FS_APIKEY,
  authDomain: process.env.REACT_APP_FS_AUTHDOMAIN,
  databaseURL: process.env.REACT_APP_FS_DATABASEURL,
  projectId: process.env.REACT_APP_FS_PROJECTID,
  storageBucket: process.env.REACT_APP_FS_STORAGEBUCKET,
  messagingSenderId: process.env.REACT_APP_FS_MESSAGINGSENDERID,
  appId: process.env.REACT_APP_FS_APPID
};

const app = initializeApp(firebaseConfig);
console.log(app)
const database = getDatabase()

const FireDeptPage = ({authLogic}) => {
  const navigate = useNavigate()//화면전환에 필요
  const onLogout = () => {
    console.log('FireDeptPage 호출')
    authLogic.logout()
  }
  
  const [depts, setDepts] = useState([]);
  useEffect(() => {
      //setDepts(depts)
      console.log('useEffect 호출')
      console.log(depts)
      console.log(database)
      const starCountRef = ref(database,'dept');
      onValue(starCountRef, (snapshot) => {
      const data = snapshot.val();
      console.log(data)
      setDepts(data)
    });
  },
  [],
  );//옵션에 별도의 값을 지정하지 않으면 최초 한번만 실행됨
  //useEffect에서 초기화 된 상태값 출력해보기
  console.log(depts)
  return (
    <>
      <Header onLogout={onLogout}/>
      <div>부서 관리 페이지</div>
      <div className="dept-list">
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>부서번호</th>
          <th>부서명</th>
          <th>지역</th>
        </tr>
      </thead>
      <tbody>
        {Object.keys(depts).map(key =>(
          <DeptRow key = {key} dept = {depts[key]}/>
        ))
        }
      </tbody>
    </Table>
      </div>
      <Bottom />
    </>
  )
}

export default FireDeptPage