import React, { useState } from 'react'

const SubPage = (props) => {
  const handleAdd = () => {
  console.log('SubPage handleAdd 호출')
  props.handleAdd(props.num)
}
const handleMinus = () => {
  console.log('SubPage handleMinus 호출')
}

return (
  <div style = {{border:'5px solid red',  width:'300px', height:'150px'}}>
    SubPage<br />
    <button onClick={handleAdd}>증가</button>
    &nbsp;
    <button onClick={handleMinus}>감소</button>
  </div>
  )
}

export default SubPage
