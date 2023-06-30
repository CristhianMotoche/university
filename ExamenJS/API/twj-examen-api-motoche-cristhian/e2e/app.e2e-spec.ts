import { TwjExamenApiMotocheCristhianPage } from './app.po';

describe('twj-examen-api-motoche-cristhian App', () => {
  let page: TwjExamenApiMotocheCristhianPage;

  beforeEach(() => {
    page = new TwjExamenApiMotocheCristhianPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
