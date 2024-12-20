import Form from 'react-bootstrap/Form';

function PriceDropdown() {
  return (
    <Form.Select aria-label="Default select example" className='DropdowonNavbar'>
      <option>Price</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </Form.Select>
  );
}

export default PriceDropdown;