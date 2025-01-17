import Card from 'react-bootstrap/Card';
import TypeTag from './TagComponents/TypeTag';
import HealthTag from './TagComponents/HealthTag';
import PriceTag from './TagComponents/PriceTag';

function RecepieCardTags({
  priceTag,
  healthTag,
  preferenceTag,
}) {
  return (
    <Card className='RecepieCardComponent RecepieCardTag'>
      <Card.Body className='RecepieCardTagBody'>
        <PriceTag priceTag={priceTag}/>
        <TypeTag preferenceTag={preferenceTag}/>
        <HealthTag healthTag={healthTag}/>
      </Card.Body>
    </Card>
  );
}

export default RecepieCardTags;