/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Zosia
 */
@Stateless
public class NewsItemFacade implements NewsItemFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public List<NewsItem> getAllNewsItems() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NewsItem> cq = cb.createQuery(NewsItem.class);
        Root<NewsItem> rootEntry = cq.from(NewsItem.class);
        CriteriaQuery<NewsItem> ct = cq.select(rootEntry);
        TypedQuery<NewsItem> allNewsItemsQuery = em.createQuery(ct);
        return allNewsItemsQuery.getResultList();
    }
}
