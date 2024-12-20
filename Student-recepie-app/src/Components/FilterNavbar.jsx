import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";

function FilterNavbar() {
  return (
    <Navbar expand="lg" className="RecepieNavbar">
      <Container>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <NavDropdown title="Price" id="basic-nav-dropdown" className="DropdowonNavbar" >
            <NavDropdown.Item href="#action/3.1">$</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.2">
              $$
            </NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">
              $$$
            </NavDropdown.Item>
          </NavDropdown>
          <NavDropdown title="Preferences" id="basic-nav-dropdown" className="DropdowonNavbar">
            <NavDropdown.Item href="#action/3.1">Preferences</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.2">
              Vegan
            </NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">Vegetarian</NavDropdown.Item>
          </NavDropdown>
          <NavDropdown title="Health" id="basic-nav-dropdown" className="DropdowonNavbar">
            <NavDropdown.Item href="#action/3.2">
              Healthy
            </NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">Day to day</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">Comfort</NavDropdown.Item>
          </NavDropdown>
        </Navbar.Collapse>
        <Navbar.Collapse className="justify-content-end">
          <NavDropdown.Item href="/create" className="GenericButon" style={{width: "200px"}}>New Recipeie</NavDropdown.Item>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default FilterNavbar;
