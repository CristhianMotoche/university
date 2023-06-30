import { SWPage } from './app.po';

describe('sw App', () => {
  let page: SWPage;

  beforeEach(() => {
    page = new SWPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
