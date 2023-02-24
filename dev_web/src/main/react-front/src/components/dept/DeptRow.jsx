import React from 'react'

const DeptRow = (props) => {
  console.log(props)
  const {dept} = props
  return (
    //< >엘리먼트 그룹핑
    <> 
      <tr>
        <td>{dept.deptno}</td>
        <td>{dept.dname}</td>
        <td>{dept.loc}</td>
      </tr>
    </>
  )
}

export default DeptRow
