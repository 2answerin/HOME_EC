import React from 'react'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import { useState } from 'react'
import { Table } from 'react-bootstrap'
import { useEffect } from 'react'

const DeptPage = () => {
  const [depts, setDepts] = useState([
    {deptno:10, dname:"1팀", loc:"부산"},
    {deptno:20, dname:"2팀", loc:"서울"},
    {deptno:30, dname:"3팀", loc:"대전"}
  ]);
  useEffect(
    () => {
      //setDepts(depts)
      console.log(depts)
    },
    [],
  );//옵션에 별도의 값을 지정하지 않으면 최초 한번만 실행됨
  return (
    <>
      <Header />
      <div>부서 관리 페이지</div>
      <div className="dept-list">
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>부서번호</th>
          <th>부서명</th>
          <th>지역</th>
        </tr>
      </thead>
      <tbody>
        {Object.keys(depts).map(key =>(
          <tr key = {key}>
            <td>{depts[key].deptno}</td>
            <td>{depts[key].dname}</td>
            <td>{depts[key].loc}</td>
          </tr>
        ))
        }
      </tbody>
    </Table>
      </div>
      <Bottom />
    </>
  )
}

export default DeptPage