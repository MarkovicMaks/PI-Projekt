import Card from 'react-bootstrap/Card';
import TypeTag from './TagComponents/TypeTag';
import HealthTag from './TagComponents/HealthTag';
import PriceTag from './TagComponents/PriceTag';

function RecepieCardTags() {
  return (
    <Card className='RecepieCardComponent RecepieCardTag'>
      <Card.Body>
        {/* <PriceTag/>
        <TypeTag/>
        <HealthTag/> */}
      </Card.Body>
    </Card>
  );
}

export default RecepieCardTags;