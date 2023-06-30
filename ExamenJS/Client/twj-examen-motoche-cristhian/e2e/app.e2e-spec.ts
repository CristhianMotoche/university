import { TwjExamenMotocheCristhianPage } from './app.po';

describe('twj-examen-motoche-cristhian App', () => {
  let page: TwjExamenMotocheCristhianPage;

  beforeEach(() => {
    page = new TwjExamenMotocheCristhianPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
