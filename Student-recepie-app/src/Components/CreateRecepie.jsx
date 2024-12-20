import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import HealthDropdown from "./TagComponents/HealthDropdown";
import TypeDropdown from "./TagComponents/TypeDropdown";
import PriceDropdown from "./TagComponents/PriceDropdown";


function CreateWindow() {
  return (
    <Form style={{width: "60vw"}}>
      <div style={{width: "30vw"}}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label style={{ color: "#f1f4f0" }}>Title</Form.Label>
          <Form.Control
            type="Username"
            placeholder="Enter Username"
            className="LoginInput"
            style={{ color: "#f1f4f0" }}
          />
        </Form.Group>
        <div>
            <HealthDropdown/>
            <TypeDropdown/>
            <PriceDropdown/>
        </div>
      </div>

      <div>
        
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
          <Form.Label  style={{ color: "#f1f4f0" }}>Recepie</Form.Label>
          <Form.Control as="textarea"className="LoginInput" rows={10} />
        </Form.Group>
      </div>

      <Button variant="primary" type="submit" className="GenericButon">
        Submit
      </Button>
    </Form>
  );
}

export default CreateWindow;
