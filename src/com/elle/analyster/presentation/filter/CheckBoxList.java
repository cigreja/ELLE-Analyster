/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elle.analyster.presentation.filter;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * CheckBoxList
 * @author cigreja
 */
public class CheckBoxList extends JList
{
    
   protected static Border noFocusBorder;

   public CheckBoxList()
   {
       // set the no focus border
       noFocusBorder = new EmptyBorder(1, 1, 1, 1);
       
       // set cell renderer
      setCellRenderer(new CellRenderer());

      // selection mode is single selection
      setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }

   protected class CellRenderer implements ListCellRenderer
   {
      public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
      {
         JCheckBox checkbox = (JCheckBox) value;
         checkbox.setBackground(isSelected ?
                 getSelectionBackground() : getBackground());
         checkbox.setForeground(isSelected ?
                 getSelectionForeground() : getForeground());
         checkbox.setEnabled(isEnabled());
         checkbox.setFont(getFont());
         checkbox.setFocusPainted(false);
         checkbox.setBorderPainted(true);
         checkbox.setBorder(isSelected ?
          UIManager.getBorder(
           "List.focusCellHighlightBorder") : noFocusBorder);
         return checkbox;
      }
   }
}